export type User = {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    roles: string[];
  };

  export type Role= {
    id: number;
    authority: string;
  }