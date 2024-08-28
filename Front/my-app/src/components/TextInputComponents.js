import React, { useState } from 'react';

function TextInputComponent() {
    const [textboxValue, setTextboxValue] = useState('');

    const handleInputChange = (event) => {
        setTextboxValue(event.target.value);
    };

    const clickButton = () => {
        if (textboxValue.trim() === "") {
            alert("Textbox cannot be empty");
            return;
        }

        fetch('http://localhost:8080/api/', {
            method: 'POST',
            mode: 'cors',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ text: textboxValue })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.statusText}`);
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
            alert("Text saved successfully");
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Failed to save text. Please try again later.");
        })
        .finally(() => {
            // Loading indicator cleanup code
        });
    };

    return (
        <div>
            <input
                type="text"
                id="textbox"
                placeholder="Textbox"
                value={textboxValue}
                onChange={handleInputChange}
            />
            <button onClick={clickButton}>InputButton</button>
        </div>
    );
}

export default TextInputComponent;
