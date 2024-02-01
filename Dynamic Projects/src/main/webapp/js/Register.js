
// fetch the users server data returned

fetch("http://localhost:8080/BiddingSystem/users")
    .then((response) => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Assuming the response is in JSON format
    })
    .then((data) => {
        // Handle the data received from the server
        if(data){

        }
        else{
            
            document.querySelector('#error-message').textContent = "Failed to log In"
        }
    })
    .catch((error) => console.error('Error:', error));

