package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.artspace.ui.theme.ArtspaceTheme
import com.example.artspace.data.Datasource
import com.example.artspace.model.Artspace
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtspaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtspaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtspaceApp() {
    ArtspaceScreen(
        artspaceList = Datasource().loadArtspace(),
    )
}

@Composable
fun ArtspaceScreen(artspaceList: List<Artspace> , modifier: Modifier = Modifier) {
    val index: MutableState<Int> = rememberSaveable { mutableStateOf(1) }


    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(artspaceList[index.value].imageResourceId),
            contentDescription = stringResource(artspaceList[index.value].artnameResourceId),
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = modifier.size(16.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(
                text = stringResource(artspaceList[index.value].artnameResourceId),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Text(
                text = stringResource(artspaceList[index.value].artyearResourceId),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = modifier.size(25.dp))
            Row(
                modifier = modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            )
            {
                Button(onClick = {
                    when (index.value){
                        1 -> index.value = 4
                        2 -> index.value = 1
                        3 -> index.value = 2
                        4 -> index.value = 3
                    }
                }) {
                    Text(
                        text = "Previous",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
                Button(onClick = {
                    when (index.value){
                    1 -> index.value = 2
                    2 -> index.value = 3
                    3 -> index.value = 4
                    4 -> index.value = 1
                }}) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
        }
    }
}

