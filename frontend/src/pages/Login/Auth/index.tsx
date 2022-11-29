import { Route, Routes } from "react-router-dom";
import ButtonIcon from "components/ButtonIcon";
import Formlogin from "./Formlogin";
import Formrecover from "./Formrecover";
import Formregister from "./Formregister/indeex";
import { useForm } from "react-hook-form";

import "./styles.css";

type FormData = {
  email: string;
  senha: string;
};

const Auth = () => {
  const { register, handleSubmit } = useForm<FormData>();

  const onSubmit = (formData: FormData) => {
    console.log(formData);
  };

  return (
    <div className="auth_container">
      <div className="auth_content base_card">
        <div className="auth_card">
          <form
            onSubmit={handleSubmit(onSubmit)}
            className="auth_form base_card"
          >
            <div className="auth_title">
              <p>LOGIN</p>
            </div>
            <input
              {...register("email")}
              className="auth_input"
              type="text"
              name="email"
              placeholder="Email"
            />
            <input
              {...register("senha")}
              className="auth_input"
              type="password"
              name="senha"
              placeholder="Senha"
            />
            <div className="auth_submit">
              <p>Esqueceu sua senha? Recuperar.</p>
              <p>Ainda não tem conta? Registrar.</p>
              <ButtonIcon text="FAZER LOGIN" />
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
    </div>
  );
};

export default Auth;
