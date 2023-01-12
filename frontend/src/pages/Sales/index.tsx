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
      <div className="container my-4">
        <div className="row">
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>
          <div className="col-sm-4 col-lg-3">
            <SaleCard />
          </div>

        </div>
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
