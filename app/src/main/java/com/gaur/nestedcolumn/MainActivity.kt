package com.gaur.nestedcolumn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gaur.nestedcolumn.ui.theme.NestedColumnTheme
import com.google.accompanist.flowlayout.FlowColumn


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedColumnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@Composable
fun MainScreen() {
    val list = getMainList()
    val context = LocalContext.current
    LazyColumn {
        items(list) {
            ListItem(mainClass = it){
                Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }


}

@Composable
fun ListItem(mainClass: MainClass,call:(String)->Unit) {

    Text(
        text = mainClass.name,
        style = TextStyle(color = Color.Black, fontSize = 20.sp),
        modifier = Modifier.padding(8.dp)
    )
    FlowColumn {
        mainClass.list.forEach {
            Text(
                modifier=Modifier.clickable { call.invoke(it.toString()) },
                text = it.toString(),
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        }
    }

}


data class MainClass(val name: String, val list: List<Int>)

fun getMainList(): List<MainClass> {
    val list = mutableListOf<MainClass>()
    list.add(MainClass(name = "one", list = mutableListOf(1, 2, 44, 5, 3, 4, 6)))
    list.add(MainClass(name = "two", list = mutableListOf(1, 2, 44, 5, 3, 4, 6)))
    list.add(MainClass(name = "three", list = mutableListOf(1, 2, 44, 5, 3, 4, 6)))
    list.add(MainClass(name = "four", list = mutableListOf(1, 2, 44, 5, 3, 4, 6)))
    list.add(MainClass(name = "five", list = mutableListOf(1, 2, 44, 5, 3, 4, 6)))
    list.add(MainClass(name = "six", list = mutableListOf(1, 2, 44, 5, 3, 4, 6)))
    return list
}
