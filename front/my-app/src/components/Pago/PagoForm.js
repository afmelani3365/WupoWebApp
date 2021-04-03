import React from 'react';

import Menu from '../Menu/Menu';

class PagoForm extends React.Component{

    constructor(props)
    {
        super(props);
        this.state = {destiny:'', value:0}

        this.handleChange = this.handleChange.bind(this);
        this.enviarPago = this.enviarPago.bind(this);
    }

    handleChange(event){
        this.setState({[event.target.name]:event.target.value});
    }

    async enviarPago(event){
        event.preventDefault();
        if(this.state.value <= 1000)
        {
            let token = localStorage.getItem('token');
            let origen = localStorage.getItem('user');
            let requestBody = {source:origen, destiny:this.state.destiny, value:this.state.value};
            console.log(JSON.stringify(requestBody));
            let response = await fetch('http://localhost:8080/user', {method:'POST', body:JSON.stringify(requestBody), headers: {'content-type':'application/json', 'authorization':'Bearer '+token} });

            if(response.ok)
            {
                alert("Se registró el pago exitosamente!");
            }
            else
            {
                console.log(response);
                alert("Ha ocurrido un error...");
            }
        }
        else
        {
            alert("No puede enviar montos mayores a 1000");
        }
    }

    componentDidMount(){
        const token = localStorage.getItem('token');
        if(token == null)
        {
            this.setState({login:true});
        }
    }

    render(){
        let debeLogin = this.state.login ? true:false;

        if(debeLogin)
        {
            return(
                <>
                <Menu/>
                <main role="main" className="flex-shrink-0 mt-5">
                    <div className="App-login">
                        <h1>Debe iniciar sesión antes de poder registrar pagos</h1>
                    </div>
                </main>
                </>
            );
        }
        else
        {
            return(
                <form onSubmit={this.enviarPago}>
                    <div className="form-group">
                        <label>Usuario del destinatario:</label>
                        <input type="text" className="form-control" name="destiny" onChange={this.handleChange} placeholder="Destinatario"/>
                    </div>
                    <div className="form-group">
                        <label>Monto a enviar:</label>
                        <input type="number" className="form-control" name="value" onChange={this.handleChange} placeholder="Valor"/>
                    </div>
                    <input type="submit" className="btn btn-primary" value="Enviar"/>
                </form>
            );
        }
    }
}

export default PagoForm;