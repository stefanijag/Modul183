import './style.css';

class viewRegister extends Component {

    setName(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, name: event.target.value}});
    }

    setLastname(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, lastname: event.target.value}});
    }
    
    setUsername(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, username: event.target.value}});
    }

    setPassword(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, password: event.target.value}});
    }

    setPasswordConfirm(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, passwordConfirm: event.target.value}});
    }

    setEmail(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, email: event.target.value}});
    }

    submit(event){
        let invalidFields = validateUser(this.state.user);
        if(invalidFields.length === 0){
            axios({
                method: "post",
                url: `http://${window.location.hostname}:8080/register`,
                withCredentials: true,
                data: {...this.state.loginBean}
            }).then(res => {
                this.props.context.setUserRole(res.data.role);
                this.setState({...this.state, redirectToHome: true});
            }).catch(error => {
                console.log(error);
                if(error.response && error.response.status === 400){
                    this.setState({...this.state, invalidFields: error.response.data, errorMsg: null});
                }
            });
        }
        else{
            this.setState({...this.state, invalidFields, errorMsg: null});
        }
    }

    render(){
        if(this.state.redirectToHome){
            return <Redirect to="/"/>;
        }

        return (
            <div>
                <form className="registerForm">
                    <h1>Registrieren</h1>
                    <table>
                        <tbody>
                            <tr className="errorMsg"><td colSpan={3}>{this.state.errorMsg}</td></tr>
                            <tr>
                                <td className="loginText">Name:</td>
                                <td><input type="text" value={this.state.name} onChange={this.setName}></input></td>
                            </tr>
                            <tr>
                                <td className="loginText">Nachname:</td>
                                <td><input type="text" value={this.state.lastname} onChange={this.setLastname}></input></td>
                            </tr>
                            <tr>
                                <td className="loginText">Username:</td>
                                <td><input type="username" value={this.state.username} onChange={this.setUsername}></input></td>
                            </tr>
                            <tr>
                                <td className="loginText">Passwort:</td>
                                <td><input type="password" value={this.state.passwort} onChange={this.setPasswort}></input></td>
                            </tr>
                            <tr>
                                <td className="loginText">Bestätige Passwort:</td>
                                <td><input type="text" value={this.state.passwordConfirm} onChange={this.setPasswordConfirm}></input></td>
                            </tr>
                             <tr>
                                <td className="loginText">Email:</td>
                                <td><input type="text" value={this.state.email} onChange={this.setEmail}></input></td>
                            </tr>
                            <tr>
                                <td><div className="button" onClick={this.submit}>Bestätigen</div></td>
                                <td><Link to="/" className="buttonLink"><div className="button">Abbrechen</div></Link></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
        );
    }
}

export default WithContext(register);