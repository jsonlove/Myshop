package com.xiecl.myShop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentCategory extends BaseBean{
        private String parentid ;
        private String 	name ;
        private String 	status ;
        private String 	sortorder ;
        @JsonProperty("isParent")
        private boolean isParent;

        public String getParentid() {
                return parentid;
        }

        public void setParentid(String parentid) {
                this.parentid = parentid;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getSortorder() {
                return sortorder;
        }

        public void setSortorder(String sortorder) {
                this.sortorder = sortorder;
        }

        public boolean isParent() {
                return isParent;
        }

        public void setParent(boolean parent) {
                isParent = parent;
        }
}
