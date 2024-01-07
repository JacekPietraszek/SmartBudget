function fetchAndDisplayTransactions() {
    fetch('http://localhost:8080/transactions')
        .then(response => response.json())
        .then(transactions => {
            const table = document.getElementById('transactionsTable');
            transactions.forEach(transaction => {
                const row = table.insertRow();
                row.insertCell(0).textContent = transaction.id;
                row.insertCell(1).textContent = transaction.typeOfTransaction;
                row.insertCell(2).textContent = transaction.category;
                row.insertCell(3).textContent = transaction.value;
                row.insertCell(4).textContent = transaction.account;
                row.insertCell(5).textContent = transaction.dateAdded;
                row.insertCell(6).textContent = transaction.comments;
            });
        })
        .catch(error => console.error('Error:', error));
}

function searchTransactions() {
    var category = document.getElementById('categorySelect').value;
    var incomeChecked = document.getElementById('income').checked;
    var expenseChecked = document.getElementById('expense').checked;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                var transactions = JSON.parse(xhr.responseText);

                clearTableRows();

                const table = document.getElementById('transactionsTable');
                transactions.forEach(transaction => {
                    if ((category === '' || transaction.category.toLowerCase() === category.toLowerCase()) &&
                        (!incomeChecked || transaction.typeOfTransaction === 'income') &&
                        (!expenseChecked || transaction.typeOfTransaction === 'expense')) {
                        const row = table.insertRow();
                        row.insertCell(0).textContent = transaction.id;
                        row.insertCell(1).textContent = transaction.typeOfTransaction;
                        row.insertCell(2).textContent = transaction.category;
                        row.insertCell(3).textContent = transaction.value;
                        row.insertCell(4).textContent = transaction.account;
                        row.insertCell(5).textContent = transaction.dateAdded;
                        row.insertCell(6).textContent = transaction.comments;
                    }
                });
            } else {
                console.error(xhr.statusText);
            }
        }
    };

    xhr.open('GET', '/transactions', true);
    xhr.send();
}

function clearTableRows() {
    const table = document.getElementById('transactionsTable');
    while (table.rows.length > 1) {
        table.deleteRow(1);
    }
}

function openAddTransactionForm() {
    window.location.href = '/addTransaction.html';
}

function addTransaction() {
    const form = document.getElementById('addTransactionForm');
    const formData = new FormData(form);

    const transactionData = {};
    formData.forEach((value, key) => {
        transactionData[key] = value;
    });

    fetch('http://localhost:8080/addTransaction', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(transactionData),
    })
        .then(response => response.json())
        .then(responseData => {
            fetchAndDisplayTransactions();
            form.reset();
            form.style.display = 'none';
        })
        .catch(error => console.error('Error:', error));
}
let currentMonth = new Date().getMonth();
let currentYear = new Date().getFullYear();

function updateMonthYear() {
    const monthYearElement = document.getElementById('monthYear');
    const months = [
        "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
        "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"
    ];
    monthYearElement.textContent = months[currentMonth] + ' ' + currentYear;
}

function previousMonth() {
    currentMonth--;
    if (currentMonth < 0) {
        currentMonth = 11;
        currentYear--;
    }
    updateMonthYear();
}

function nextMonth() {
    currentMonth++;
    if (currentMonth > 11) {
        currentMonth = 0;
        currentYear++;
    }
    updateMonthYear();
}

document.addEventListener('DOMContentLoaded', fetchAndDisplayTransactions);