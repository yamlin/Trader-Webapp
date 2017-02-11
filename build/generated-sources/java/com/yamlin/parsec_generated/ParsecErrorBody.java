package com.yamlin.parsec_generated;

import java.util.List;

public final class ParsecErrorBody implements java.io.Serializable {

    private Integer code;
    private String message;

    private List<ParsecErrorDetail> detail;

    public ParsecErrorBody() { }

    public Integer getCode() { return code; }

    public String getMessage() { return message; }

    public List<ParsecErrorDetail> getDetail() { return detail; }

    public ParsecErrorBody setCode(Integer code) { this.code = code; return this; }

    public ParsecErrorBody setMessage(String message) { this.message = message; return this; }

    public ParsecErrorBody setDetail(List<ParsecErrorDetail> detail) { this.detail = detail; return this; }
}
