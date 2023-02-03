package ru.itcube.triviacube.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Card
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleChoiceList(
    list: List<String>,
    selectedId:Int,
    onSelected:(String) -> Unit){

    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(list[selectedId])
    }
    Column(Modifier.selectableGroup()) {

        list.forEach{
            Card(modifier = Modifier
                .fillMaxWidth()
                //.height(60.dp)
                .padding(10.dp)
                .selectable(
                    selected = (it == selectedOption),
                    onClick = {
                        onOptionSelected(it)
                        onSelected(it)
                    }
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = (it==selectedOption), onClick = null)
                    Text(text = it, fontSize = 22.sp)
                }
            }

        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
private fun SingleChoiceListPreview(){
    val selected = remember {
        mutableStateOf("")
    }
    Column() {
        Text(text = selected.value)
        SingleChoiceList(
            list = listOf("1","2","3"),
            selectedId =0,
            onSelected = {selected.value = it}
        )
    }
}