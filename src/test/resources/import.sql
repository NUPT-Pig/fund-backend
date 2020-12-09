INSERT INTO fund_tb (fund_id, fund_code, fund_name) VALUES (1, '501010', '汇添富中证生物科技主题指数（LOF）C');
INSERT INTO fund_tb (fund_id, fund_code, fund_name) VALUES (2, '001618', '天弘中证电子指数C');
INSERT INTO fund_tb (fund_id, fund_code, fund_name) VALUES (3, '001044', '嘉实新消费股票');
INSERT INTO fund_tb (fund_id, fund_code, fund_name) VALUES (4, '160222', '国泰国证食品饮料行业');
INSERT INTO fund_tb (fund_id, fund_code, fund_name) VALUES (5, '004070', '南方中证全指证券ETF联接C');

INSERT INTO stock_tb (stock_id, stock_code, stock_name) VALUES (1, '000661', '长春高新');
INSERT INTO stock_tb (stock_id, stock_code, stock_name) VALUES (2, '603259', '药明康德');
INSERT INTO stock_tb (stock_id, stock_code, stock_name) VALUES (3, '300347', '泰格医药');

INSERT INTO stock_rating_tb (id, fund_id, stock_id, rate) VALUES (1, 1, 1, 9.72);
INSERT INTO stock_rating_tb (id, fund_id, stock_id, rate) VALUES (2, 1, 2, 8.98);
INSERT INTO stock_rating_tb (id, fund_id, stock_id, rate) VALUES (3, 1, 3, 5.2);