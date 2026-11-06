package org.insbaixcamp.appfitnessa.ui.screen

import android.widget.Button
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.appfitnessa.ui.theme.AppFitnessATheme
import org.insbaixcamp.appfitnessa.tools.CalcularImc


@Composable
fun WeightTrackingScreen(
    pesActual: Double,
    pesObjectiu: Double,
    alçada: Int
) {
    var pesNou : Double by remember { mutableStateOf(75.0) }
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(top = 16.dp)) {
            Card(Modifier.weight(1f).padding(8.dp)) {
                Text(text = "Pes actual:")
                Text(text = "$pesActual")
            }
            Card(Modifier.weight(1f).padding(8.dp)) {
                Text(text = "Pes objectiu:")
                Text(text = "$pesObjectiu")
            }
            Card(Modifier.weight(1f).padding(8.dp)) {
                Text(text = "IMC: ")
                var imc = CalcularImc.calcularImc(pesActual, alçada)
                Text(imc.toString())

            }
        }
        Text("Registra un nou pes")
        OutlinedTextField(
            value = pesNou.toString(),
            onValueChange = { pesNou = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )
        Button(onClick = {
            // TODO: Guardar pes
        },
            modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text("Guardar pes")
        }
        Text(text = "Evolució del pes",
            Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp))
        Box(modifier = Modifier.fillMaxWidth()
                                .height(150.dp))
        Text("Últims registres")
    }
}
@Preview(showBackground = true)
@Composable
fun WeightTrackingScreenPreview() {
    AppFitnessATheme() {
        WeightTrackingScreen(70.0, 60.0, 170)
    }
}