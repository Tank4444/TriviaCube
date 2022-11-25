package ru.itcube.triviacube.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun variantsGrid(list: List<String>,gridCells: GridCells,onSelect: (Int) -> Unit){
    val nlist:List<Variant> = list.map {Variant(it,false)   }
    LazyVerticalGrid(
        cells = gridCells,

        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(nlist.size){
                Variant(text = list[it], onSelected = onSelect(it))
            }
        }
    )
}
data class Variant(val text: String,var selected:Boolean)
@Composable
fun Variant(
    text:String,
    onSelected:(String)-> Unit
){
    Card(modifier = Modifier.clickable { onSelected(text) }) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            Text(text = text)
        }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun variantsGridPreview(){
    variantsGrid(
        listOf("Poetry","Healer","dsnjf","juhdnsfju","juidhnasfju","ojidasfju","okljdhnsj"),
        GridCells.Adaptive(100.dp)
    ){

    }
}