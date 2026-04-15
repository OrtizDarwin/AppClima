package com.darwin.clima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaDetalle(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaDetalle(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFA0B5EB),
                        Color(0xFFEA52F8),
                        Color(0xFF0066FF)
                    )
                )
            )
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text("El Salvador", color = Color.White, fontSize = 24.sp)

        Text(
            "25°C",
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Text("Soleado", color = Color.White)

        Spacer(modifier = Modifier.height(20.dp))

        Text("PRONÓSTICO POR HORAS", color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HoraItem("Ahora", "☀️", "25°")
            HoraItem("14:00", "☀️", "26°")
            HoraItem("16:00", "⛅", "24°")
            HoraItem("18:00", "⛅", "22°")
            HoraItem("20:00", "🌙", "20°")
        }

        Spacer(modifier = Modifier.height(20.dp))

        CardDetalle()

        Spacer(modifier = Modifier.height(20.dp))

        Text("PRONÓSTICO SEMANAL", color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        CardSemana()
    }
}

@Composable
fun HoraItem(hora: String, icono: String, temp: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(hora, color = Color.White)
        Text(icono)
        Text(temp, color = Color.White)
    }
}

@Composable
fun CardDetalle() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text("DETALLES", color = Color.White)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Humedad", color = Color.White)
                    Text("65%", color = Color.White)
                }
                Column {
                    Text("Viento", color = Color.White)
                    Text("12 km/h", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Presión", color = Color.White)
                    Text("1012 hPa", color = Color.White)
                }
                Column {
                    Text("UV", color = Color.White)
                    Text("5", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CardSemana() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            DiaItem("Lun", "☀️", "28° / 22°")
            DiaItem("Mar", "⛅", "27° / 21°")
            DiaItem("Mié", "🌧️", "26° / 20°")
            DiaItem("Jue", "⛅", "25° / 19°")
            DiaItem("Vie", "🌦️", "24° / 18°")
        }
    }
}

@Composable
fun DiaItem(dia: String, icono: String, temp: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(dia, color = Color.White)
        Text(icono)
        Text(temp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewClima() {
    ClimaTheme {
        PantallaDetalle()
    }
}