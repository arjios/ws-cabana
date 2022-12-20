import { Route, Routes, useNavigate } from "react-router-dom";
import ButtonIcon from "components/ButtonIcon";
import Formlogin from "./Formlogin";
import Formrecover from "./Formrecover";
import Formregister from "./Formregister/index";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { requestBackendLogin, storeAuthData } from "util/requests";

import "./styles.css";


type FormData = {
  username: string;
  password: string;
};

const Auth = () => {
  const [hasError, setHasError] = useState(false);

  const { register, handleSubmit, formState: { errors } } = useForm<FormData>();

  const history = useNavigate();

  const onSubmit = (formData: FormData) => {
    requestBackendLogin(formData)
      .then((response) => {
        storeAuthData(response.data);
        setHasError(false);
        console.log("Sucesso! ", response);
        history('/sales');
      })
      .catch((error) => {
        setHasError(true);
        console.log("Error ", error);
      });
  };

  return (
    <div className="auth_container">
      <div className="auth_content base_card">
        <form onSubmit={handleSubmit(onSubmit)} className="auth_form base_card">
          <div className="auth_title">
            <p>LOGIN</p>
          </div>
          {hasError && (
            <div className="alert alert-danger auth_input">
              Email ou senha invalida!
            </div>
          )}
          <div className="mb-4">
            <input
              {...register("username", {
                required: "Campo não deve estar em branco",
                pattern: {
                  value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                  message: "Email invalido!"
                } 
              })}
              className={`form-control base_input auth_input ${errors.username?'is-invalid':''}`}
              type="text"
              name="username"
              placeholder="Email"
            />
            <div className="d-block invalid-feedback">{errors.username?.message}</div>
          </div>
          <div className="mb-2">
            <input
              {...register("password", {
                required: "Senha não pode estar em branco",
                minLength: {
                  value: 6,
                  message: "O campo deve conter 6 digitos no minimo!"
                }
              })}
              className={`form-control base_input auth_input ${errors.password?'is-invalid':''}`}
              type="password"
              name="password"
              placeholder="Senha"
            />
            <div className="d-block invalid-feedback">{errors.password?.message}</div>
          </div>
          <div className="auth_submit">
            <p>Esqueceu sua senha? Recuperar.</p>
            <ButtonIcon text="FAZER LOGIN" />
            <p>Ainda não tem conta? Registrar.</p>
          </div>
        </form>

        <Routes>
          <Route path="/login/auth/formlogin" element={<Formlogin />} />
        </Routes>
        <Routes>
          <Route path="/login/auth/formregister" element={<Formregister />} />
        </Routes>
        <Routes>
          <Route path="/login/auth/formrecover" element={<Formrecover />} />
        </Routes>
      </div>
    </div>
  );
};

export default Auth;
