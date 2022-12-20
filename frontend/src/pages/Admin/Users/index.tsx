import { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { User } from "types/user";
import { SpringPage } from "types/vendor/spring";
import { requestBackend } from "util/requests";

const Users = () => {
  const [page, setPage] = useState<SpringPage <User> >();

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
      <p key={x.id}>{x.firstName}</p>
    ))}
  </div>
  );
};

export default Users;
