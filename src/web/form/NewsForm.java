package web.form;

import web.core.ActionForm;

public class NewsForm extends ActionForm{

	private String npost_title;
	private String nsave;
	private String npublish;
	private String advanced_view;
	private String pods_meta_exttitle1;
	private String pods_meta_yuanwenlianjie;
	private String comment_status;
	private String pods_meta_exttitle2;
	private String metavalue;
	private String metakeyinput;
	private String post_format;
	private String pods_meta;
	private String ninja_form_select;
	private String pods_meta_yuanwenbiaoti;
	private String content;
	private String _wp_http_referer;
	private String pods_meta_jkm_post_id;
	private String pods_meta_guanjianci;
	private String nf_append_form;
	private String post_name;
	
	private String trackback_url;
	
	
	public String get_wp_http_referer() {
		return _wp_http_referer;
	}
	public void set_wp_http_referer(String _wp_http_referer) {
		this._wp_http_referer = _wp_http_referer;
	}
	
	
	
	public String getMetavalue() {
		return metavalue;
	}
	public void setMetavalue(String metavalue) {
		this.metavalue = metavalue;
	}
	public String getMetakeyinput() {
		return metakeyinput;
	}
	public void setMetakeyinput(String metakeyinput) {
		this.metakeyinput = metakeyinput;
	}
	public String getPost_format() {
		return post_format;
	}
	public void setPost_format(String post_format) {
		this.post_format = post_format;
	}
	public String getPods_meta() {
		return pods_meta;
	}
	public void setPods_meta(String pods_meta) {
		this.pods_meta = pods_meta;
	}
	public String getNinja_form_select() {
		return ninja_form_select;
	}
	public void setNinja_form_select(String ninja_form_select) {
		this.ninja_form_select = ninja_form_select;
	}
	public String getPods_meta_yuanwenbiaoti() {
		return pods_meta_yuanwenbiaoti;
	}
	public void setPods_meta_yuanwenbiaoti(String pods_meta_yuanwenbiaoti) {
		this.pods_meta_yuanwenbiaoti = pods_meta_yuanwenbiaoti;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPods_meta_jkm_post_id() {
		return pods_meta_jkm_post_id;
	}
	public void setPods_meta_jkm_post_id(String pods_meta_jkm_post_id) {
		this.pods_meta_jkm_post_id = pods_meta_jkm_post_id;
	}
	public String getPods_meta_guanjianci() {
		return pods_meta_guanjianci;
	}
	public void setPods_meta_guanjianci(String pods_meta_guanjianci) {
		this.pods_meta_guanjianci = pods_meta_guanjianci;
	}
	public String getNf_append_form() {
		return nf_append_form;
	}
	public void setNf_append_form(String nf_append_form) {
		this.nf_append_form = nf_append_form;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	
	public String getTrackback_url() {
		return trackback_url;
	}
	public void setTrackback_url(String trackback_url) {
		this.trackback_url = trackback_url;
	}
	public String getAdvanced_view() {
		return advanced_view;
	}
	public void setAdvanced_view(String advanced_view) {
		this.advanced_view = advanced_view;
	}
	public String getPods_meta_exttitle1() {
		return pods_meta_exttitle1;
	}
	public void setPods_meta_exttitle1(String pods_meta_exttitle1) {
		this.pods_meta_exttitle1 = pods_meta_exttitle1;
	}
	public String getPods_meta_yuanwenlianjie() {
		return pods_meta_yuanwenlianjie;
	}
	public void setPods_meta_yuanwenlianjie(String pods_meta_yuanwenlianjie) {
		this.pods_meta_yuanwenlianjie = pods_meta_yuanwenlianjie;
	}
	public String getComment_status() {
		return comment_status;
	}
	public void setComment_status(String comment_status) {
		this.comment_status = comment_status;
	}
	public String getPods_meta_exttitle2() {
		return pods_meta_exttitle2;
	}
	public void setPods_meta_exttitle2(String pods_meta_exttitle2) {
		this.pods_meta_exttitle2 = pods_meta_exttitle2;
	}
	
	@Override
	public String toString() {
		return "NewsForm [npost_title=" + npost_title + ", nsave=" + nsave
				+ ", npublish=" + npublish + ", advanced_view=" + advanced_view
				+ ", pods_meta_exttitle1=" + pods_meta_exttitle1
				+ ", pods_meta_yuanwenlianjie=" + pods_meta_yuanwenlianjie
				+ ", comment_status=" + comment_status
				+ ", pods_meta_exttitle2=" + pods_meta_exttitle2
				+ ", metavalue=" + metavalue + ", metakeyinput=" + metakeyinput
				+ ", post_format=" + post_format + ", pods_meta=" + pods_meta
				+ ", ninja_form_select=" + ninja_form_select
				+ ", pods_meta_yuanwenbiaoti=" + pods_meta_yuanwenbiaoti
				+ ", content=" + content + ", _wp_http_referer="
				+ _wp_http_referer + ", pods_meta_jkm_post_id="
				+ pods_meta_jkm_post_id + ", pods_meta_guanjianci="
				+ pods_meta_guanjianci + ", nf_append_form=" + nf_append_form
				+ ", post_name=" + post_name + ", trackback_url="
				+ trackback_url + "]";
	}
	public String getNpost_title() {
		return npost_title;
	}
	public void setNpost_title(String npost_title) {
		this.npost_title = npost_title;
	}
	public String getNsave() {
		return nsave;
	}
	public void setNsave(String nsave) {
		this.nsave = nsave;
	}
	public String getNpublish() {
		return npublish;
	}
	public void setNpublish(String npublish) {
		this.npublish = npublish;
	}
}
