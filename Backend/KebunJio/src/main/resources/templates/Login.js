import React, { useState } from "react";
import axios from "axios";

function Login() {
    const [emailOrUsername, setEmailOrUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("/api/users/login", {
                emailOrUsername,
                password,
            });
            alert(response.data);
        } catch (error) {
            alert("Login failed! " + error.response.data);
        }
    };

    return (
        <div>
            <h2>Log in</h2>
            <form onSubmit={handleLogin}>
                <input
                    type="text"
                    placeholder="Enter email or user name"
                    value={emailOrUsername}
                    onChange={(e) => setEmailOrUsername(e.target.value)}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button type="submit">Log in</button>
            </form>
        </div>
    );
}

export default Login;
