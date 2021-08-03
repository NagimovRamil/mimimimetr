function vote(ID) {
    sendRequest(ID, '/voting');
    location.reload();
}

function sendRequest(data, url) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, false);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
}