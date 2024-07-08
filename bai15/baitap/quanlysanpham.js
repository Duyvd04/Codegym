// app.js

let products = ["Sony Xperia", "Samsung Galaxy", "Nokia 6", "Xiaomi Redmi Note 4", "Apple iPhone 6S", "Xiaomi Mi 5s Plus", "Apple iPhone 8 Plus", "Fujitsu F-04E", "Oppo A71"];

function displayProducts() {
    const productTable = document.getElementById('productList');
    productTable.innerHTML = '';

    products.forEach((product, index) => {
        const row = document.createElement('tr');

        const productNameCell = document.createElement('td');
        productNameCell.textContent = product;
        row.appendChild(productNameCell);

        const editCell = document.createElement('td');
        const editButton = document.createElement('button');
        editButton.className = 'btn';
        editButton.textContent = 'Edit';
        editButton.onclick = () => editProduct(index);
        editCell.appendChild(editButton);
        row.appendChild(editCell);

        const deleteCell = document.createElement('td');
        const deleteButton = document.createElement('button');
        deleteButton.className = 'btn delete';
        deleteButton.textContent = 'Delete';
        deleteButton.onclick = () => deleteProduct(index);
        deleteCell.appendChild(deleteButton);
        row.appendChild(deleteCell);

        productTable.appendChild(row);
    });
}

function addProduct() {
    const productNameInput = document.getElementById('productName');
    const newProduct = productNameInput.value.trim();

    if (newProduct) {
        products.push(newProduct);
        productNameInput.value = '';
        displayProducts();
    } else {
        alert("Please enter a product name.");
    }
}

function editProduct(index) {
    const newProductName = prompt("Enter new name for the product:", products[index]);
    if (newProductName) {
        products[index] = newProductName;
        displayProducts();
    }
}

function deleteProduct(index) {
    products.splice(index, 1);
    displayProducts();
}

// Initialize the product list
displayProducts();
