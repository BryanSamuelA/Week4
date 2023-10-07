package com.example.week4.ui.view

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4.R
import com.example.week4.model.Explore
import com.example.week4.data.DataSource
import com.example.week4.model.Feed
import com.example.week4.model.Story
import com.example.week4.model.Suggestion
import com.example.week4.model.products
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun soal3View(storyList: List<Story>, feedList: List<Feed>, suggestionList: List<Suggestion>) {

    var counter:Int =6
    Box(

        modifier = Modifier
            .background(Color(36, 36, 36))
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {


        LazyVerticalGrid(
            columns = GridCells.Fixed(1)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_dark),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .height(40.dp)
                            .width(150.dp)

                    )

                    Spacer(modifier = Modifier.width(100.dp))

                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.dm),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                }
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(start = 0.dp, end = 0.dp, bottom = 10.dp)
                ) {
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            val context = LocalContext.current
                            IconButton(
                                onClick = {
                                    Toast.makeText(context, "Your Story", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier
                                    .height(120.dp)
                                    .width(105.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {


                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .padding(8.dp, bottom = 2.dp)
                                            .fillMaxWidth()

                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.story),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(90.dp),
                                            contentScale = ContentScale.Crop

                                        )
                                        Image(
                                            painter = painterResource(id = getResourceID(nameoffile = "profile_12")),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .clip(shape = CircleShape)
                                                .size(80.dp),
                                            contentScale = ContentScale.Crop


                                        )
                                    }
                                    TextTitleAndDesc(
                                        "Your Story",
                                        FontWeight.Normal,
                                        14.sp,
                                        Color.LightGray,
                                        TextAlign.Justify,
                                        1,
                                        Modifier.padding(top = 0.dp)
                                    )

                                }

                            }
                        }
                    }
                    items(storyList) {
                        storyCard(
                            it,
                            Modifier
                                .padding()
                        )
                    }

                }
            }



            if (counter == 6) {
                item {
                    LazyRow(
                        modifier = Modifier.padding(start = 0.dp, end = 0.dp, bottom = 10.dp)
                    ) {
                        items(suggestionList) {
                            suggestionCard(
                                it,
                                Modifier
                                    .padding()
                            )
                        }
                    }
                }
                counter = 1
            } else {
                counter += 1
            }



            items(feedList) {
                feedCard(it, modifier = Modifier)
            }


        }


    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
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
                Toast.makeText(context, "Home Button", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Search Button", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Post Button", Toast.LENGTH_SHORT).show()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.post),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Reels Button", Toast.LENGTH_SHORT).show()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.reels),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Account Button", Toast.LENGTH_SHORT).show()
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






@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun soal3Preview() {
    soal3View(DataSource().loadStory(), DataSource().loadFeed(), DataSource().loadSuggestion())
}

@Composable
fun storyCard(Story: Story, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        val context = LocalContext.current
        IconButton(
            onClick = {
                Toast.makeText(context, "${Story.username} Story", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .height(120.dp)
                .width(105.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(8.dp, bottom = 2.dp)
                        .fillMaxWidth()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.story),
                        contentDescription = null,
                        modifier = Modifier
                            .size(90.dp),
                        contentScale = ContentScale.Crop

                    )
                    Image(
                        painter = painterResource(id = getResourceID(nameoffile = Story.avatar)),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .size(80.dp),
                        contentScale = ContentScale.Crop


                    )
                }
                TextTitleAndDesc(
                    Story.username,
                    FontWeight.Normal,
                    14.sp,
                    Color.LightGray,
                    TextAlign.Center,
                    1,
                    Modifier
                        .padding(top = 0.dp)
                        .widthIn(max = 95.dp)
                )

            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun feedCard(Feed: Feed, modifier: Modifier = Modifier) {

    var Expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = getResourceID(nameoffile = Feed.avatar)),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(40.dp),
                contentScale = ContentScale.Crop


            )

            TextTitleAndDesc(
                Feed.username,
                FontWeight.Normal,
                14.sp,
                Color.LightGray,
                TextAlign.Justify,
                1,
                Modifier.padding(top = 0.dp)
            )

            Spacer(modifier = Modifier.width(200.dp))

            Image(
                painter = painterResource(id = R.drawable.baseline_more_horiz_24),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .rotate(90.0F),
            )


        }
        Image(
            painter = painterResource(id = getResourceID(nameoffile = Feed.content)),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val context = LocalContext.current
            IconButton(onClick = {
                Toast.makeText(
                    context, if (Feed.bool1) {
                        "Liked Button"
                    } else {
                        "Like button"
                    }, Toast.LENGTH_SHORT
                ).show()
            }) {
                if (Feed.bool1) {
                    Image(
                        painter = painterResource(id = R.drawable.liked),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            IconButton(onClick = {
                Toast.makeText(context, "Comment Button", Toast.LENGTH_SHORT).show()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Send Button", Toast.LENGTH_SHORT).show()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.messanger),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.width(200.dp))
            IconButton(onClick = {
                Toast.makeText(
                    context, if (Feed.bool2) {
                        "Saved Button"
                    } else {
                        "Save Button"
                    }, Toast.LENGTH_SHORT
                ).show()
            }) {
                if (Feed.bool2) {
                    Image(
                        painter = painterResource(id = R.drawable.saved_light),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.save),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }


        }

        Column(
            modifier = Modifier.padding(10.dp, top = 0.dp)
        ) {

            TextTitleAndDesc(
                if (Feed.like == 1) {
                    "${Feed.like} like"
                } else if (Feed.like >= 1000) {
                    "${Feed.like / 1000}.${String.format("%03d", Feed.like % 1000)} likes"
                } else {
                    "${Feed.like} likes"
                },
                FontWeight.Normal,
                14.sp,
                Color.LightGray,
                TextAlign.Justify,
                1,
                Modifier.padding(top = 0.dp)
            )




            TextButton(
                onClick = { Expanded = !Expanded },
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxSize()
                    .offset(x = (-11).dp, y = (-10).dp),
            )
            {
                val text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = Bold, fontSize = 14.sp)) {
                        append("${Feed.username} ")
                    }
                    withStyle(style = SpanStyle(fontWeight = Normal, fontSize = 14.sp)) {
                        append(Feed.caption)
                    }
                }
                if (!Expanded) {

                    Text(
                        text = text,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        maxLines = 2,
                        color = Color.LightGray,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp)
                    )

                } else {
                    Text(
                        text = text,
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp,
                        maxLines = 5000,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp)
                    )
                }
            }

            TextTitleAndDesc(
                formatDate(Feed.date),
                FontWeight.Normal,
                12.sp,
                Color.Gray,
                TextAlign.Justify,
                1,
                Modifier
                    .padding(top = 0.dp)
                    .offset(y = (-18).dp)
            )
        }


    }


}

@Composable
fun suggestionCard(Suggestion: Suggestion, modifier: Modifier = Modifier) {

        Card(
            modifier= Modifier
                .width(175.dp)
                .height(250.dp)
                .padding(horizontal = 15.dp, vertical = 10.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color(36, 36, 36)),
            border = BorderStroke(1.dp, Color.LightGray),


        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "Close",
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopEnd)
                        .offset(y=(-8).dp,x=(-2).dp),
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {


                    Image(
                        painter = painterResource(id = getResourceID(nameoffile = Suggestion.avatar)),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    
                    TextTitleAndDesc(
                        text = Suggestion.username,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.LightGray,
                        textAlign = TextAlign.Center,
                        maxLine =1 ,
                        modifier = Modifier.padding(top=10.dp, bottom = 6.dp)
                    )
                    val context = LocalContext.current

                    Button(
                        onClick = {
                            Toast.makeText(context, "Follow Button", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors( Color(36,160,237)),
                        shape = RoundedCornerShape(12.dp),
                    ) {
                        TextTitleAndDesc(
                            text = "Follow",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            maxLine =1 ,
                            modifier = Modifier.padding()
                        )
                    }
                }
            }
        }






}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun formatDate(inputDate: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val outputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")

    val date = LocalDate.parse(inputDate, inputFormatter)
    if (date.year == 2023) {
        return date.format(DateTimeFormatter.ofPattern("MMMM d"))
    } else {
        return date.format(outputFormatter)
    }
}

