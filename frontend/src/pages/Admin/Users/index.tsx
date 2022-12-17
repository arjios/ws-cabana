import { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { User } from "types/user";
import { SpringPage } from "types/vendor/spring";
import { requestBackend } from "util/requests";

const Users = () => {
  const [page, setPage] = useState<SpringPage<User>>();

  useEffect(() => {
    const params: AxiosRequestConfig = {
      url: "/admin/users",
      withCredentials: true,
      params: {
        page: 0,
        size: 12,
      },
    };

    requestBackend(params).then((response) => {
      setPage(response.data);
    });
  }, []);
  
return (
  <div className="row">
    {page?.content.map((x) => (
      <div key={x.id}>
        <Link to="/admin/users">
          <p>{x.firstName}</p>
        </Link>
      </div>
    ))}
  </div>
  );
};

export default Users;
