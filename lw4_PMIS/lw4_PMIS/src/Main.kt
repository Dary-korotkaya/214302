/*13.	Создание системы отчетности с использованием обобщений: 
Напишите систему отчетности для компании, включающую обобщенные 
классы Report<T> и SummaryReport<T>. Реализуйте методы для создания 
отчетов по различным аспектам бизнеса (например, продажи, расходы, 
производительность сотрудников) с поддержкой фильтрации и агрегации данных.*/

open class Report<T>(
    private val data: List<T>
) {
    fun filter(predicate: (T) -> Boolean): List<T> {
        return data.filter(predicate)
    }
    fun aggregate(selector: (T) -> Double): Double {
        return data.sumOf(selector)
    }
    fun display() {
        data.forEach { println(it) }
    }
}

class SummaryReport<T>(
    private val report: Report<T>
) {
    fun getTotal(selector: (T) -> Double): Double {
        return report.aggregate(selector)
    }
    fun displaySummary(selector: (T) -> Double) {
        println("Сводный отчет:")
        report.display()
        println("Общая сумма: ${getTotal(selector)}")
    }
}

data class Sale(val product: String, val amount: Double)
data class Expense(val category: String, val cost: Double)
data class EmployeePerformance(val name: String, val hoursWorked: Int)

fun main() {
    val salesData = listOf(
        Sale("Телефон", 100.0),
        Sale("Компьютер", 150.0),
        Sale("Телевизор", 200.0)
    )

    val salesReport = Report(salesData)
    println("Отчет по продажам:")
    salesReport.display()

    val salesSummary = SummaryReport(salesReport)
    salesSummary.displaySummary { sale -> sale.amount }

    val expensesData = listOf(
        Expense("Реклама", 100.0),
        Expense("Производство", 500.0),
        Expense("Доставка", 200.0)
    )

    val expensesReport = Report(expensesData)
    println("\nОтчет по расходам:")
    expensesReport.display()

    val expensesSummary = SummaryReport(expensesReport)
    expensesSummary.displaySummary { expense -> expense.cost }

    val performanceData = listOf(
        EmployeePerformance("Катя", 40),
        EmployeePerformance("Саша", 35),
        EmployeePerformance("Петя", 45)
    )

    val performanceReport = Report(performanceData)
    println("\nОтчет по производительности сотрудников:")
    performanceReport.display()

    val performanceSummary = SummaryReport(performanceReport)
    performanceSummary.displaySummary { performance -> performance.hoursWorked.toDouble() }
}
