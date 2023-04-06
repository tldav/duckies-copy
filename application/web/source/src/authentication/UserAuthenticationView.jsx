import React, { useEffect, useRef, useState } from "react";
import userList from "../data/user.json";

function UserAuthenticationView() {
	const [loginStatusMessage, setLoginStatusMessage] = useState("");

	const usernameRef = useRef(null);
	const passwordRef = useRef(null);

	const onLoginSubmit = (e) => {
		e.preventDefault();
		const user = getUserByName(usernameRef.current.value);
		const password = passwordRef.current.value;
		if (user && user.password === password) {
			setLoginStatusMessage("Logged in");
		} else {
			setLoginStatusMessage("Invalid username or password");
		}
	};

	useEffect(() => {}, []);

	const getUserByName = (username) => {
		return userList.find((user) => username === user.username);
	};

	const areCredentialsValid = () => {};

	return (
		<div id="login">
			<div id="login-title">Login</div>
			<form onSubmit={onLoginSubmit}>
				<span>Username</span>
				<input
					name="username-field"
					placeholder="Username"
					type="text"
					ref={usernameRef}
					onBlur={() => usernameRef.current.value}
				></input>
				<span>Password</span>
				<input
					name="password-field"
					placeholder="Password"
					type="password"
					ref={passwordRef}
					onBlur={() => passwordRef.current.value}
				></input>
				<button id="submit-button">Submit</button>
			</form>
			<div id="login-status-message">{loginStatusMessage}</div>
		</div>
	);
}

export default UserAuthenticationView;
