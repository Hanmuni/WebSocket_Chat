let socket = new SockJS('http://localhost:8080/ws');
let stompClient = Stomp.over(socket);

let messageButton = document.querySelector(".message-btn");

stompClient.connect({}, (frame) => {
    console.log('Verbunden' + frame);

    stompClient.subscribe('/topic/chat', (message) => {
        receivedMessage(message.body);
        console.log(message);
    })

    messageButton.addEventListener("click", () => {
        let message = document.querySelector('#message-input').value;
        stompClient.send('/app/chat/sendMessage', {}, JSON.stringify(message));
        document.querySelector('#message-input').value = '';
        console.log('Messgae added"')
    })

    const receivedMessage = (message) => {
        message = JSON.stringify(message);
        let messageDOM = document.createElement('li');
        messageDOM.innerText = message;
        document.querySelector('#messages').appendChild(messageDOM);
    }
})