import React from 'react';

class LoginForm extends React.Component{
    
    constructor(props){
        super(props);
        this.state = {username: '', passwd: '', redirect: false};

        this.handleChange = this.handleChange.bind(this);
        this.solicitarLogin = this.solicitarLogin.bind(this);
    }

    handleChange(event){
        this.setState({[event.target.name]:event.target.value});
    }

    async solicitarLogin(event){
        event.preventDefault();
        let response = await fetch('http://localhost:8080/', {method:'POST', body:JSON.stringify(this.state), headers: {'content-type':'application/json'} });
        
        if(response.ok)
        {
            let resultado = await response.json();
            if(!resultado.success)
            {
                //El usuario no existia así que se registró uno
                //nuevo
                let mensaje = resultado.token;
                alert(mensaje);
            }
            else
            {
                //El login fue exitoso
                localStorage.setItem('token', resultado.token);
                localStorage.setItem('user',this.state.username);
                this.setState({redirect: true});
            }
        }
        else
        {
            let resError = await response.json();
            alert(resError.message);
        }
    }

    render(){

        if(this.state.redirect || localStorage.getItem('token') != null)
        {
            return(
                <>
                <main role="main" className="flex-shrink-0 mt-5">
                    <div className="App-login">
                        <h1>Ya iniciaste sesión. Bienvenido {localStorage.getItem('user')}!</h1>
                    </div>
                </main>
                </>
            )
        }
        return(
            <form onSubmit={this.solicitarLogin}>
                <div className='form-group'>
                    <label>Usuario:</label>
                    <input type="text" className="form-control" name="username" onChange={this.handleChange} placeholder="Nombre de usuario"/>
                </div>
                <div className='form-group'>
                    <label>Contraseña:</label>
                    <input type="password" className="form-control" name="passwd" onChange={this.handleChange} placeholder="Contraseña"/>
                </div>
                <input type="submit" className="btn btn-primary" value="Iniciar Sesión"/>
            </form>
        )
    }
}

export default LoginForm;