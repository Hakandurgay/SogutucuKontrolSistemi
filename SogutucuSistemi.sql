--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- Name: aboneler; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aboneler (
    id integer NOT NULL,
    abone_ad text
);


ALTER TABLE public.aboneler OWNER TO postgres;

--
-- Name: aboneler_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.aboneler ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.aboneler_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: personeller; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personeller (
    id integer NOT NULL,
    personel_sifre text,
    personel_ad_soyad text
);


ALTER TABLE public.personeller OWNER TO postgres;

--
-- Name: personeller_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.personeller ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.personeller_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: aboneler; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.aboneler VALUES (1, 'kenanbirkan');
INSERT INTO public.aboneler VALUES (2, 'omerucar');
INSERT INTO public.aboneler VALUES (3, 'emin@gmail.com');
INSERT INTO public.aboneler VALUES (4, 'hh');
INSERT INTO public.aboneler VALUES (5, 'anakinskywalker@gmail.com');


--
-- Data for Name: personeller; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.personeller VALUES (1, 'cengiz123', 'cengizbozkurt');
INSERT INTO public.personeller VALUES (3, 'hakan123', 'hakandurgay');
INSERT INTO public.personeller VALUES (4, 'ahmet123', 'ahmetmehmet');
INSERT INTO public.personeller VALUES (5, 'mehmet123', 'mehmetsari');
INSERT INTO public.personeller VALUES (6, 'ahmet123', 'ahmetsari');
INSERT INTO public.personeller VALUES (7, 'h123', 'hakan');
INSERT INTO public.personeller VALUES (8, 'e123', 'emin');
INSERT INTO public.personeller VALUES (9, 'hakan123', 'hakan');
INSERT INTO public.personeller VALUES (11, '111', 'skywalker');
INSERT INTO public.personeller VALUES (12, '123456', 'kamil kaya');
INSERT INTO public.personeller VALUES (13, 'hakan111', 'hakandurgayy');
INSERT INTO public.personeller VALUES (14, '111', 'hakan');
INSERT INTO public.personeller VALUES (15, '234235', 'hakanwerw');
INSERT INTO public.personeller VALUES (16, '34242', 'hakandur');
INSERT INTO public.personeller VALUES (17, '345', 'dgdfg');
INSERT INTO public.personeller VALUES (18, '234', 'hakanerte');
INSERT INTO public.personeller VALUES (19, '234', 'hakan4567');
INSERT INTO public.personeller VALUES (20, '1234', 'hakandurgay');
INSERT INTO public.personeller VALUES (21, '3456', 'hakan');


--
-- Name: aboneler_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aboneler_id_seq', 5, true);


--
-- Name: personeller_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.personeller_id_seq', 21, true);


--
-- Name: aboneler aboneler_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aboneler
    ADD CONSTRAINT aboneler_pkey PRIMARY KEY (id);


--
-- Name: personeller personeller_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personeller
    ADD CONSTRAINT personeller_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

