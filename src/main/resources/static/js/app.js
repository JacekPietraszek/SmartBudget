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
    var category = document.getElementById('searchInput').value;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                var transactions = JSON.parse(xhr.responseText);

                clearTableRows();

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
            } else {

                console.error(xhr.statusText);
            }
        }
    };

    xhr.open('GET', '/transactions?category=' + encodeURIComponent(category), true);
    xhr.send();
}

function clearTableRows() {
    const table = document.getElementById('transactionsTable');
    while (table.rows.length > 1) {
        table.deleteRow(1);
    }
}

document.addEventListener('DOMContentLoaded', fetchAndDisplayTransactions);