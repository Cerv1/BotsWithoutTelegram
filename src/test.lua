
-- send_msg (Adri, "it's working")

-- extension.onPhotoReceive = funciont(msg)

local function callback(extra, success, result)
  if success then
    print('File downloaded to:', result)
  else
    print('Error downloading: '..extra)
  end
end

function on_msg_receive (msg)
      -- if msg.out then
      --     return
      -- end
      -- if (msg.photo.width ~= nil) then
      --    send_msg (msg.from.print_name, 'it works', ok_cb, false)
      -- end

      if (msg.from.first_name == "ImageBot") then
          load_photo(msg.id, callback, msg.id)
        -- send_msg (msg.from.print_name, msg.text, ok_cb, false)
      end
  end

function on_our_id (id)
end

function on_secret_chat_created (peer)
end

function on_user_update (user)
end

function on_chat_update (user)
end

function on_get_difference_end ()
end

function on_binlog_replay_end ()
end
