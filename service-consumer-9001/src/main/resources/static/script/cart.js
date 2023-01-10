function editCart(cartItemId, buyCount) {
    window.location.href = '/editCart?cartItemId=' + cartItemId + '&buyCount=' + buyCount
}

function delCartItem(cartItemId) {
    window.location.href = '/delCartItem?id=' + cartItemId
}