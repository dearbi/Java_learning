var div = document.querySelector('div');
div.onclick = function () {
    console.log(div.className);
    if (div.className.indexOf('light') != -1) {
        div.className = 'container dark';
    } else {
        div.className = 'container light';
    }
}
