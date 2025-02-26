import { useEffect, useState } from "react";
import axios from "axios";

function App() {
    const [message, setMessage] = useState("");

    useEffect(() => {
        axios.get("http://localhost:8080/api/hello")
            .then(response => setMessage(response.data))
            .catch(error => console.error("Error fetching data:", error));
    }, []);

    return (
        <div>
            <h1>React + Spring Boot</h1>
            <p>{message}</p>
        </div>
    );
}

export default App;