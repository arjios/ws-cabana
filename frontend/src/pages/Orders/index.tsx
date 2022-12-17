import { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Order } from "types/order";
import { SpringPage } from "types/vendor/spring";
import { requestBackend, BASE_URL } from "util/requests";

const Orders = () => {
  const [page, setPage] = useState<SpringPage<Order>>();

  useEffect(() => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: "/orders",
      baseURL: BASE_URL,
      withCredentials: true,
      params: {
        page: 0,
        size: 12,
      }
    };

    requestBackend(params).then((response) => {
      setPage(response.data);
    });
  }, []);
  
  return(
  <div className="row">
    {page?.content.map((x) => (
        <div key={x.id}>
        <Link to="/orders">
          <p>Numero mesa{x.account}</p>
          <p>{x.status}</p>
        </Link>
      </div>
    ))}
  </div>
  );
};

export default Orders;
