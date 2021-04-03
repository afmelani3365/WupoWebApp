import React from 'react';

import Menu from '../Menu/Menu';
import LoginForm from './LoginForm';


function Login()
{
    return(
        <>
        <Menu/>
        <main role="main" className="flex-shrink-0 mt-5">
            <div className="App-login">
                <LoginForm/>
            </div>
        </main>
        </>
    );
}

export default Login;