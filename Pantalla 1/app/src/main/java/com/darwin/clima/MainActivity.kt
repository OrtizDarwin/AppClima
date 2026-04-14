package com.darwin.clima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darwin.clima.ui.theme.ClimaTheme
import androidx.compose.material3.Icon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimaTheme {
                ClimaApp()
            }
        }
    }
}

@Composable
fun ClimaApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF72EAFF),
                        Color(0xFF72C2FF),
                        Color(0xFF003888)
                    )
                )
            )
    ) {
        ContenidoClima()
    }
}

@Composable
fun ContenidoClima() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "El Salvador",
            color = Color.White,
            fontSize = 24.sp
        )

        Text(
            text = "25°C",
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Icon(
            imageVector = Icons.Default.Place,
            contentDescription = "Ubicación",
            tint = Color.White,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        CardClima()

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { }) {
            Text("ACTUALIZAR")
        }
    }
}

@Composable
fun CardClima() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("HUM", color = Color.White)
                Text("65%", color = Color.White)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("VIENTO", color = Color.White)
                Text("12 km/h", color = Color.White)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("LLUVIA", color = Color.White)
                Text("10%", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewClima() {
    ClimaTheme {
        ClimaApp()
    }
}