package ru.itcube.triviacube.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MultiChoiceList(
    list: List<String>,
    selectedId:List<String>,
    onSelected:(List<String>) -> Unit){

    val selected = remember {
       selectedId.toMutableList()
    }
    Column(Modifier.selectableGroup()) {

        list.forEach{
            Card(modifier = Modifier
                .fillMaxWidth()
                //.height(60.dp)
                .padding(10.dp)
                .selectable(
                    selected = (selected.contains(it)),
                    onClick = {
                        if(selected.contains(it)) selected.remove(it)
                        else selected.add(it)
                        onSelected(selected.toList())
                    }
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = (selected.contains(it)), onCheckedChange = null)
                    Text(text = it, fontSize = 22.sp)
                }
            }

        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun MultiChoiceListPreview(){
    val selected = remember {
        mutableStateOf("")
    }
    Column() {
        Text(text = selected.value)
        MultiChoiceList(
            list = listOf("1","2","3"),
            selectedId = listOf("2","3"),
            onSelected = {
                selected.value = it.toString()
            }
        )
    }
}