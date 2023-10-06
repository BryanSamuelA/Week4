package com.example.week4.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4.R
import com.example.week4.model.Explore
import com.example.week4.data.DataSource
import com.example.week4.model.products

@Composable
fun soal4View(exploreList: List<Explore>) {
    var isian by rememberSaveable { mutableStateOf("") }


    Box(

        modifier = Modifier
            .background(Color(36,36,36))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            item(span = { GridItemSpan(3) }) {
                CustomTextField(
                    value = isian,
                    onValueChanged = { isian = it },
                    text = "Search",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                )
            }
            items(exploreList) {

                    ExploreCard(
                        it,
                        Modifier
                    )

            }
            item(span={GridItemSpan(3) }){
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Row(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.Black),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                val context = LocalContext.current
                IconButton(onClick = {
                    Toast.makeText(context,"Home Button", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = {
                    Toast.makeText(context,"Search Button", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = {
                    Toast.makeText(context,"Post Button", Toast.LENGTH_SHORT).show()
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.post),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = {
                    Toast.makeText(context,"Reels Button", Toast.LENGTH_SHORT).show()
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.reels),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = {
                    Toast.makeText(context,"Account Button", Toast.LENGTH_SHORT).show()
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.account),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }




            }
        }

    }

}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun soal4Preview() {
    soal4View(DataSource().loadExplore())
}




@Composable
fun ExploreCard(Exlpore: Explore, modifier: Modifier = Modifier) {
    val screenWidth = LocalDensity.current.run {
        LocalConfiguration.current.screenWidthDp.dp
    }

    val cardSize = (screenWidth / 3)

    val context = LocalContext.current

    IconButton(
        onClick = {
            Toast.makeText(context, Exlpore.idString, Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.size(cardSize) // Set the size of the IconButton
    ) {
        Image(
            painter = painterResource(id = getResourceID(nameoffile = Exlpore.idString)),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(), // Fill the available space within the IconButton
            contentScale = ContentScale.FillBounds
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        textStyle = TextStyle(color = Color.LightGray),
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
            textColor = Color.LightGray,
        ),
        placeholder = {
            if (value.isEmpty()) {
                Text(text = text, style = TextStyle(color = Color.LightGray))
            }
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = null, tint = Color.Black)
        }
    )
}


@Composable
fun getResourceID(nameoffile: String): Int {
    val context = LocalContext.current
    val resourceID = remember(nameoffile) {
        context.resources.getIdentifier(nameoffile, "drawable", context.packageName)
    }
    return resourceID
}

