package com.example.testrepository

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testrepository.ui.theme.TestRepositoryTheme

class MainActivityMaterial: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestRepositoryTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCardMaterial(MessageMaterial("Android", "Jetpack Compose"))
                }
            }
        }
    }
}

data class MessageMaterial(val author: String, val body: String)

@Composable
fun MessageCardMaterial(msg: MessageMaterial) {
    // Add padding around a message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.test),
            contentDescription = "Test picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        // Add horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(text = msg.body,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(device = Devices.PIXEL_6, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewMessageCardMaterial() {
    TestRepositoryTheme {
        Surface {
            MessageCardMaterial(MessageMaterial("Colleague", "Take a look at Jetpack Compose, it's great"))
        }
    }
}