
// Inventory array to store items

let inventory = [];

function addProduct() {
    const type = document.getElementById('productType').value;
    const name = document.getElementById('productName').value;
    const price = document.getElementById('productPrice').value;
    const quantity = document.getElementById('productQuantity').value;

    if (type && name && price && quantity) {
        const product = { type, name, price: parseFloat(price), quantity: parseInt(quantity) };
        inventory.push(product);
        updateInventoryList();
        clearProductInputs();
    }
}

function updateInventoryList() {
    const inventoryList = document.getElementById('inventoryList');
    inventoryList.innerHTML = '';

    inventory.forEach((product, index) => {
        const listItem = document.createElement('li');
        listItem.className = 'list-group-item d-flex justify-content-between';
        listItem.innerHTML = `
            ${product.type}: ${product.name} - 
            Price: ₹${product.price} - 
            Qty: ${product.quantity}
            <button onclick="removeProduct(${index})" class="btn btn-sm btn-danger">Remove</button>
        `;
        inventoryList.appendChild(listItem);
    });
}

function removeProduct(index) {
    inventory.splice(index, 1);
    updateInventoryList();
}

function clearProductInputs() {
    document.getElementById('productType').value = '';
    document.getElementById('productName').value = '';
    document.getElementById('productPrice').value = '';
    document.getElementById('productQuantity').value = '';
}


