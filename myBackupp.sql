--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2026-03-02 21:27:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 420549)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    unitprice numeric(10,2) NOT NULL,
    qty integer,
    importdate date DEFAULT CURRENT_DATE
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 420548)
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.products_id_seq OWNER TO postgres;

--
-- TOC entry 4851 (class 0 OID 0)
-- Dependencies: 217
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- TOC entry 4695 (class 2604 OID 420552)
-- Name: products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- TOC entry 4845 (class 0 OID 420549)
-- Dependencies: 218
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, name, unitprice, qty, importdate) FROM stdin;
1	Banana	12.50	5	2026-02-27
2	Orange	12.00	10	2026-02-27
3	Apple	15.25	8	2026-02-27
4	Mango	18.75	12	2026-02-27
5	Pineapple	20.00	6	2026-02-27
6	Papaya	14.50	9	2026-02-27
7	Grapes	16.30	15	2026-02-27
8	Watermelon	22.00	4	2026-02-27
9	Strawberry	25.60	7	2026-02-27
10	Blueberry	30.40	11	2026-02-27
11	Kiwi	19.90	13	2026-02-27
12	Peach	17.80	10	2026-02-27
13	Cherry	28.50	6	2026-02-27
14	Pear	13.40	14	2026-02-27
15	Guava	11.75	20	2026-02-27
16	Dragon Fruit	27.00	5	2026-02-27
17	Lychee	24.60	18	2026-02-27
18	Coconut	21.30	8	2026-02-27
19	Avocado	26.90	9	2026-02-27
20	Pomegranate	29.10	7	2026-02-27
\.


--
-- TOC entry 4852 (class 0 OID 0)
-- Dependencies: 217
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 20, true);


--
-- TOC entry 4698 (class 2606 OID 420554)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


-- Completed on 2026-03-02 21:27:00

--
-- PostgreSQL database dump complete
--

