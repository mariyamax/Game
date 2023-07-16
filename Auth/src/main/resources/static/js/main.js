'use strict';

var gameTable = document.querySelector('#gameTable');

var stompClient = null;
var username = null;
var server = null;
var token = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];


function connect(event) {
    console.log("connecting");
    username = document.querySelector('#name').value.trim();
    console.log(username);
    server = document.querySelector('#server').value.trim();
    console.log(server);
    token = document.querySelector('#token').value.trim();
    if(username) {
        console.log(username);
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}

function onConnected() {
    console.log("Subscribe to the Public Topic");

    const str1 = '/server/';
    stompClient.subscribe(str1.concat(server), onMessageReceived);

    // Tell your username to the server
    stompClient.send("/app/server.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    //connectingElement.classList.add('hidden');
}


function onError(error) {
    console.log("Can not connect");
   // connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
   // connectingElement.style.color = 'red';
}


function sendMessage(event) {
    const dest = "/app/server/"
    console.log(event.srcElement.attributes.id);
    var messageContent = event.srcElement.attributes.id;
    if(messageContent && stompClient) {
        console.log("sending");
        var action = {
            token: token,
            cellId: messageContent.value,
        };
        stompClient.send(dest.concat(server), {}, JSON.stringify(action));
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    console.log("messageReceived");
    console.log(payload.body);
    var message = JSON.parse(payload.body);
    var selector = '#'.concat(message.cellId);
    console.log(selector);
    var cell =  document.querySelector(selector);
    colorize(cell);


}


window.addEventListener("load", (event) => {
   connect(event);
});


gameTable.addEventListener('click',sendMessage,true)
//messageForm.addEventListener('load',connect,true)
