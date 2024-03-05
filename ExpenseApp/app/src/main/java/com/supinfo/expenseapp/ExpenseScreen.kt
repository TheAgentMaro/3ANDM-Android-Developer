package com.supinfo.expenseapp


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Définir une classe Expense pour représenter une dépense
data class Expense(val name: String, val amount: Double)

// Créer une liste mutable pour stocker les dépenses
val expenseList = mutableListOf<Expense>()

@Composable
fun ExpenseScreen() {
    // Variables pour stocker le nom et le montant de la dépense
    var expenseName by remember { mutableStateOf("") }
    var expenseAmount by remember { mutableStateOf("") }

    // Liste pour stocker les dépenses enregistrées
    val savedExpenses = remember { mutableStateListOf<String>() }

    // Fonction pour sauvegarder la dépense
    fun saveExpense() {
        if (expenseName.isNotBlank() && expenseAmount.isNotBlank()) {
            val expense = Expense(expenseName, expenseAmount.toDouble())
            expenseList.add(expense)
            savedExpenses.add(expense.toString())
            expenseName = ""
            expenseAmount = ""
        } else {
            //afficher message d'erreur
            Log.e("ExpenseScreen", "Le nom et le montant de la dépense ne peuvent pas être vides")
        }
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Nom de la dépense")
        TextField(value = expenseName, onValueChange = { expenseName = it })
        Text(text = "Montant de la dépense")
        TextField(value = expenseAmount, onValueChange = { expenseAmount = it })
        Button(onClick = { saveExpense() }) {
            Text(text = "Enregistrer")
        }
        // Afficher les dépenses enregistrées
        Text(text = "Dépenses enregistrées :")
        savedExpenses.forEach { expense ->
            Text(text = expense)
        }
    }

}