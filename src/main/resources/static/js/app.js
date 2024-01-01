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

document.addEventListener('DOMContentLoaded', fetchAndDisplayTransactions);