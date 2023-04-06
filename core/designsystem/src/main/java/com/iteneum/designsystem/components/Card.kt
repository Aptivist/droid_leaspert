package com.iteneum.designsystem.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.theme.LPTypography

@Composable
fun LpBasicCard(
    modifier: Modifier = Modifier,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(1.dp),
        content = content
    )
}

/**
 * Create [LpPostCard] compose for user's posts
 *
 * @param modifier to modify an specific property of the card
 * @param userName a String value of the user name
 * @param userPhoto a painter assigned to the user
 * @param timeAgo the float value of the minutes of the post
 * @param messagePost the string of the post
 * @param sizeWidth the desire width of the card between 0 (0%) to 1 (100%)
 * @param onCommentClick high order function
 * @param onFavoriteClick high order function
 *
 * @author Juan Ramon Islas Huesca
 */
@Composable
fun LpPostCard(
    modifier: Modifier,
    userName: String,
    userPhoto: Painter,
    timeAgo: String,
    messagePost: String,
    sizeWidth: Float  = 1F,
    onCommentClick: () -> Unit,
    onFavoriteClick: () -> Unit
){
    Card(
        modifier = modifier
            .fillMaxWidth(sizeWidth)
            .padding(15.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(1.dp),
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 15.dp, 15.dp, 5.dp)
        ){
            Row {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth(0.20f)
                        .padding(0.dp)) {
                        Image(
                            painter = userPhoto,
                            contentDescription = "userPhoto",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                        )
                    }
                }
                Column {
                    Text(
                        text = userName,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = timeAgo,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }
            Row(modifier = Modifier.padding(10.dp)){
                Text(
                    text = messagePost,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 15.sp
                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                IconButton(onClick = onCommentClick) {
                    Icon(
                        Icons.Outlined.Comment,
                        "Comment",
                        modifier = Modifier,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Favorite",
                        modifier = Modifier,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

/**
 * This function create a card with an icon and description
 *
 * @param icon The icon to be displayed
 * @param description Description to be displayed below the icon
 * @param onCardClick onClick event when card is clicked
 * @sample IconTextCardExample This is a usage example
 *
 * @author Jose Guadalupe Rivera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpIconTextCard(
    icon: ImageVector,
    description: String,
    onCardClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .heightIn(120.dp, 250.dp)
            .padding(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
        shape = RoundedCornerShape(12.dp),
        onClick = { onCardClick(description) },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = description,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = description,
                    style = LPTypography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}


// this is an example of LpIconTextCard implementation
@Preview
@Composable
fun IconTextCardExample() {
    val list = remember {
        mutableStateListOf("Amenities", "x", "y", "gf")
    }
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(0.dp)
    ) {
        items(list) { description ->
            LpIconTextCard(
                icon = Icons.Outlined.Add,
                description = description
            ) { card ->
                // onClick: your functionality here
                Log.e("tag", card) // show selected card message
            }
        }
    }
}

