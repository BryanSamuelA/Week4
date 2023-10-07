package com.example.week4.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4.Greeting
import com.example.week4.R
import com.example.week4.data.dummy_data
import com.example.week4.model.categories
import com.example.week4.model.line_chat
import com.example.week4.model.products
import com.example.week4.ui.theme.Week4Theme

@Composable
fun soal2View(categoriesList: List<categories>,productsList: List<products>) {
    Column(modifier = Modifier
        .padding(start = 0.dp, end = 0.dp, top = 20.dp)
        .fillMaxSize(),
        )
    {
        Row(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 10.dp),
        ) {
            TextTitleAndDesc(
                "Tokopedia",
                FontWeight.ExtraBold,
                26.sp,
                Color.Black,
                TextAlign.Justify,
                1,
                Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.width(190.dp))

            Image(
                painter = painterResource(id = R.drawable.baseline_more_horiz_24blc),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(90.0f)
                    .weight(1f)
            )


        }
        Image(
            painter = painterResource(id = R.drawable.abc9f095_8389_47c1_9d05_5338036b5d39),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 20.dp, top = 0.dp, end = 20.dp)


        )

        TextTitleAndDesc(
            "Categories",
            FontWeight.ExtraBold,
            26.sp,
            Color.Black,
            TextAlign.Left,
            1,
            Modifier.padding(start = 20.dp, bottom = 10.dp)
        )



        LazyRow(modifier = Modifier.padding(start = 0.dp, end = 0.dp, bottom = 20.dp)

        ){
            items(categoriesList){
                CategoriesCard(it,
                Modifier
                    .padding())
            }
            item{
                Spacer(modifier = Modifier.width(20.dp))
            }
        }



        TextTitleAndDesc(
            "Products",
            FontWeight.ExtraBold,
            26.sp,
            Color.Black,
            TextAlign.Left,
            1,
            Modifier.padding(start = 20.dp, bottom = 10.dp)
        )


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),

        ){
            items(productsList){
                ProductCard(it,
                    Modifier
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp)
                        .fillMaxSize())
            }
        }









    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun soal2Preview(){
    soal2View(dummy_data().get_data_tokopedia_category(),dummy_data().get_data_tokopedia_product())
}


@Composable
fun CategoriesCard(categories: categories, modifier: Modifier = Modifier) {


    Card(
        modifier = modifier
            .height(200.dp)
            .width(175.dp)
            .padding(start = 20.dp, end = 0.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)




    ) {
        Column(modifier= Modifier.fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = categories.image_path),
                contentDescription = "categories image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.FillBounds
            )
            TextTitleAndDesc(
                categories.category_name,
                FontWeight.Bold,
                26.sp,
                Color.Black,
                TextAlign.Center,
                1,
                Modifier.padding(top = 10.dp)
            )
            TextTitleAndDesc(
                "${categories.number_of_items} Products",
                FontWeight.Normal,
                16.sp,
                Color.Black,
                TextAlign.Center,
                1,
                Modifier.padding()
            )





        }
    }
}
@Composable
fun ProductCard(products:products,modifier: Modifier=Modifier){

    Card(
        modifier = modifier
            .height(200.dp)
            .width(175.dp)
            .padding(start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)

    ) {
        Column(modifier= Modifier.fillMaxSize(),


        ) {
            Image(
                painter = painterResource(id = products.image_path),
                contentDescription = "categories image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 5.dp),
                contentScale = ContentScale.FillHeight
            )

            TextTitleAndDesc(
                products.product_name,
                FontWeight.SemiBold,
                20.sp,
                Color.Black,
                TextAlign.Left,
                1,
                Modifier.padding(top = 10.dp, start = 20.dp)
            )

            TextTitleAndDesc(
                "Rp.${products.price.toString()}",
                FontWeight.Normal,
                14.sp,
                Color.Black,
                TextAlign.Left,
                1,
                Modifier.padding( start = 20.dp)
            )
            TextTitleAndDesc(
                "Kota ${products.location}",
                FontWeight.Normal,
                14.sp,
                Color.Black,
                TextAlign.Left,
                1,
                Modifier.padding( start = 20.dp)
            )
            TextTitleAndDesc(
                "${products.sold.toString()} sold",
                FontWeight.Normal,
                14.sp,
                Color.Black,
                TextAlign.Left,
                1,
                Modifier.padding( start = 20.dp)
            )




        }

    }

}










