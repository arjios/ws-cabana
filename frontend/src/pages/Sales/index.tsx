import { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { Order } from "types/order";
import { SpringPage } from "types/vendor/spring";
import { requestBackend } from "util/requests";
import { getTokenData } from "util/requests";

const Sales = () => {
  const [page, setPage] = useState<SpringPage <Order> >();

  useEffect(() => {
    const params: AxiosRequestConfig = {
      url: "/sales",
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
    <h1>Vendas</h1>
    <h5>Usuario:{getTokenData()?.user_name}</h5>
    {page?.content.map((x) => (
      <p key={x.id}>{x.account} {x.status}</p>
    ))}
  </div>
  );
};

export default Sales;
