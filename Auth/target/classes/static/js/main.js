var start = document.getElementById('start');

function sendMessage(event) {
    console.log(event);
    event.preventDefault();
}

start.addEventListener('submit', sendMessage, true)