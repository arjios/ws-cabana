export type User = {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    role: Role;
  };

  export type Role= {
    id: number;
    authority: string;
  }