package com.example.week4.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.week4.model.line_chat
import com.example.week4.ui.theme.Week4Theme



@Composable
fun soal1View(line_chatList: List<line_chat>) {

    Column(modifier = Modifier.background(Color.Black)) {
        Row(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 20.dp)
        ){
            TextTitleAndDesc(
                "Chats",
                FontWeight.Bold,
                26.sp,
                Color.White,
                TextAlign.Justify,
                1,
                Modifier.padding(start= 16.dp)
            )
            Spacer(modifier = Modifier.width(220.dp))

            Image(
                painter = painterResource(id = R.drawable.baseline_density_medium_24),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .weight(1f)
            )



        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
        ) {
            items(line_chatList) {
                line_chatCard(
                    it,


                )
            }
        }

        Spacer(modifier = Modifier.height(200.dp))

    }
}




@Composable
fun line_chatCard(chat: line_chat, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .clickable {
                val message = "${chat.username} Clicked"
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24white),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .weight(1f)
        )
        Column(
            modifier = Modifier.weight(2f)
        ) {
            TextTitleAndDesc(
                chat.username,
                FontWeight.Bold,
                20.sp,
                Color.White,
                TextAlign.Justify,
                2,
                Modifier.padding(bottom = 0.dp)
            )
            TextTitleAndDesc(
                chat.chat,
                FontWeight.Normal,
                14.sp,
                Color.White,
                TextAlign.Justify,
                2,
                Modifier.padding(bottom = 0.dp)
            )
        }
        TextTitleAndDesc(
            chat.chat_date,
            FontWeight.Normal,
            12.sp,
            Color.White,
            TextAlign.Right,
            1,
            Modifier
                .padding(bottom = 0.dp, end = 30.dp)
                .weight(1f)
        )
    }
}








@Composable
fun TextTitleAndDesc(
    text: String,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    color: Color,
    textAlign: TextAlign,
    maxLine: Int, // Add the maxLine parameter
    modifier: Modifier
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        textAlign = textAlign,
        maxLines = maxLine, // Set the maxLines parameter
        modifier = modifier
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun soal1Preview(){
    soal1View(dummy_data().get_data_line())

}
