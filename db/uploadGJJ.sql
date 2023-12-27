insert into infoshar_1458931363 (thirdcoldstorageinfoid, applytime, applyname, applycontactinfo, storageentname, lerep,
                                 contractname, contracttel, storagename, storageprovince,
                                 storageprovname,
                                 storagecity,
                                 storagecityname,
                                 storagecounty,
                                 storagecountyname,
                                 storageaddress, storagepowerton, storagepowercubicmeter,
                                 uniscid, recnum, rectime, entrytime, handleunitcode
    ,handleunit
    ,proxyname
    ,proxycontactinfo
    ,receiver)
values ();

-- 查询上报数据
select p.id, p.createtime, p.apply_name, p.apply_contact_info, p.storage_ent_name, p.le_rep,
       p.contract_name, p.contract_tel, p.storage_name, p.storage_province,
       (select name from code_addiv where code=p.storage_province) as storage_prov_name,
       p.storage_city,
       (select name from code_addiv where code=p.storage_city) as storage_city_name
        , p.storage_county,
       (select name from code_addiv where code=p.storage_county) as storage_county_name,
       p.storage_address, p.storage_power_ton, p.storage_power_cubic_meter
        , p.unisc_id, p.rec_num, p.rec_time, p.entry_time, p.issueorg,
       (select name from code_organ where code=p.issueorg) as handleunit,
(select name from nf_agent where businid=(select id from nf_busin where rffsspid=p.id) and name is not null order by createtime desc limit 0, 1) as proxyname,
(select mobile from nf_agent where businid=(select id from nf_busin where rffsspid=p.id) and mobile is not null order by createtime desc limit 0, 1) as proxycontactinfo,
(select name from nf_checked where businid=(select id from nf_busin where rffsspid=p.id) and ctype=1 and name is not null order by createtime desc limit 0, 1) as receiver
from nf_rffssp p left join nf_busin b on p.id=b.rffsspid
WHERE b.status = 22 and b.btype in ( 10 , 11 , 12 , 20 , 21 , 22 )
  and p.issueorg like '23%'

-- 查询有问题数据
select * from (
select p.id, p.createtime, p.apply_name, p.apply_contact_info, p.storage_ent_name, p.le_rep,
       p.contract_name, p.contract_tel, p.storage_name, p.storage_province,
       (select name from code_addiv where code=p.storage_province) as storage_prov_name,
       p.storage_city,
       (select name from code_addiv where code=p.storage_city) as storage_city_name
        , p.storage_county,
       (select name from code_addiv where code=p.storage_county) as storage_county_name,
       p.storage_address, p.storage_power_ton, p.storage_power_cubic_meter
        , p.unisc_id, p.rec_num, p.rec_time, p.entry_time, p.issueorg,
       (select name from code_organ where code=p.issueorg) as handleunit,
(select name from nf_agent where businid=(select id from nf_busin where rffsspid=p.id) and name is not null order by createtime desc limit 0, 1) as proxyname,
(select mobile from nf_agent where businid=(select id from nf_busin where rffsspid=p.id) and mobile is not null order by createtime desc limit 0, 1) as proxycontactinfo,
(select name from nf_checked where businid=(select id from nf_busin where rffsspid=p.id) and ctype=1 and name is not null order by createtime desc limit 0, 1) as receiver
from nf_rffssp p where p.status=3
    ) tt where length(tt.unisc_id)!=18 or proxyname is null or proxycontactinfo is null or receiver is null



insert into infoshar_1458931363 (thirdcoldstorageinfoid, applytime, applyname, applycontactinfo, storageentname, lerep,
                                 contractname, contracttel, storagename, storageprovince,
                                 storageprovname,
                                 storagecity,
                                 storagecityname,
                                 storagecounty,
                                 storagecountyname,
                                 storageaddress, storagepowerton, storagepowercubicmeter,
                                 uniscid, recnum, rectime, entrytime, handleunitcode
    ,handleunit
    ,proxyname
    ,proxycontactinfo
    ,receiver)

