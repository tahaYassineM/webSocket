function sendMessage() {
    if (window.WebSocket) {
        var ws = new WebSocket("ws://localhost:8080/ServerProject/serverEndpoint");
        ws.onopen = function () {
            ws.send($("#textMessage").val());
            $("#message").append("Message is sent...\n");
        };
        ws.onmessage = function (evt) {
            var received_msg = evt.data;
            $("#message").append(received_msg + " \n");
        };
        ws.onclose = function () {
            $("#message").append("Connection is closed...\n");
        };
        window.onbeforeunload = function (event) {
            socket.close();
        };
    } else {
        $("#message").append("WebSocket NOT supported by your Browser!");
    }
}


