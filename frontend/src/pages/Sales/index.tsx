import { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { Order } from "types/order";
import { SpringPage } from "types/vendor/spring";
import { requestBackend } from "util/requests";
import { getTokenData } from "util/requests";
import SaleCard from "components/SaleCard";

import "./styles.css";
import SubBar from "components/SubBar";

const Sales = () => {
  const [page, setPage] = useState<SpringPage<Order>>();

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
    <>
      <SubBar name={getTokenData()?.user_name} />
      <div className="row my-4">
        <SaleCard />
        {page?.content.map((x) => (
          <p className="sale-row" key={x.id}>
            {x.account} {x.status}
          </p>
        ))}
      </div>
    </>
  );
};

export default Sales;
